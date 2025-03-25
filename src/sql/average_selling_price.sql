-- https://leetcode.com/problems/average-selling-price/description/?envType=study-plan-v2&envId=top-sql-50

SELECT p.product_id,
       round(sum(price * COALESCE(units, 0)) / COALESCE(sum(units), 1), 2) as average_price
FROM
    prices p
LEFT JOIN
     unitsSold s
ON
    p.product_id = s.product_id
WHERE
    (s.purchase_date between p.start_date AND p.end_date) OR (s.purchase_date is null)
GROUP by
    p.product_id
