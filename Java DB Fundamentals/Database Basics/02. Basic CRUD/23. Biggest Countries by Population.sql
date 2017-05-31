SELECT 
    c.country_name, c.population
FROM
    countries AS c
WHERE
    c.continent_code = 'EU'
ORDER BY c.population DESC, c.country_name
LIMIT 30;