-- https://leetcode.com/problems/monthly-transactions-i/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    DATE_FORMAT(t.trans_date, '%Y-%m') AS month,
    t.country,
    count(*) AS trans_count,
    COALESCE(approved_count, 0) AS approved_count,
    sum(amount) AS trans_total_amount,
    COALESCE(sb.approved_total_amount, 0) AS approved_total_amount

FROM
    transactions t
    LEFT JOIN
        (
        SELECT country, count (*) AS approved_count, sum (amount) AS approved_total_amount, DATE_FORMAT(trans_date, '%Y-%m') AS month
        FROM
            transactions
        WHERE
            state = 'approved'
        GROUP BY
            month, country
        ) as sb
ON
    DATE_FORMAT(t.trans_date, '%Y-%m') = sb.month AND (t.country = sb.country OR t.country is null AND sb.country is null)
GROUP BY
    DATE_FORMAT(t.trans_date, '%Y-%m'), t.country


-- Simple answer :)


SELECT
    LEFT(trans_date, 7) AS month,
    country,
    COUNT(id) AS trans_count,
    SUM(state = 'approved') AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM((state = 'approved') * amount) AS approved_total_amount
FROM
    Transactions
GROUP BY
    month, country;




SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country, count(*) as trans_count,
    sum(state = 'approved') as approved_count,
    sum(amount) as trans_total_amount,
    sum(CASE WHEN state = 'approved' THEN amount ELSE 0 END) as approved_total_amount
FROM
    Transactions
GROUP BY
    country, month