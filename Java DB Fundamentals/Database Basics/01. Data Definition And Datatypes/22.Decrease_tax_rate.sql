UPDATE payments
SET payments.tax_rate=tax_rate - (tax_rate * 0.03);
SELECT tax_rate FROM payments;