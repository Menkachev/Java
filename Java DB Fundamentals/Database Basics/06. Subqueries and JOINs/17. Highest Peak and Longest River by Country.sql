SELECT 
    c.`country_name`,
    mount.`highest_peak_elevation`,
    riv.`longest_river_lenght`
FROM
    `countries` AS c
        INNER JOIN
    (SELECT 
        c.`country_code`,
            MAX(p.`elevation`) AS 'highest_peak_elevation'
    FROM
        `countries` AS c
    INNER JOIN `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
    INNER JOIN `peaks` AS p ON mc.`mountain_id` = p.`mountain_id`
    GROUP BY c.`country_code`) AS mount ON c.`country_code` = mount.`country_code`
        INNER JOIN
    (SELECT 
        cr.`country_code`, MAX(r.`length`) AS 'longest_river_lenght'
    FROM
        `countries_rivers` AS cr
    INNER JOIN `rivers` AS r ON cr.`river_id` = r.`id`
    GROUP BY cr.`country_code`) AS riv ON c.`country_code` = riv.`country_code`
ORDER BY mount.`highest_peak_elevation` DESC , riv.`longest_river_lenght` DESC , c.`country_code`
LIMIT 5;