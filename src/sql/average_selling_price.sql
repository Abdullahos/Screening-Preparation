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



-- Another Sol BAD, the main idea is corrupted, as the COALESCE(sum(units), 1), 2) in the first query get
-- executed after the aggregation not for each, so the second sol is just complicating things by overhead of nested join

SELECT
    p.product_id as product_id,
    round(sum(price * COALESCE(units, 0)) /  COALESCE(no_of_selling_product, 1), 2) as average_price
FROM
    Prices p
        LEFT JOIN
    (
        UnitsSold s
            LEFT JOIN
            (SELECT
                 sum(units)as no_of_selling_product,
                 product_id as product_id
             FROM
                 UnitsSold
             GROUP BY
                 product_id
            ) as sb
        ON
            s.product_id = sb.product_id
        )

    ON
        p.product_id = s.product_id
WHERE
    (s.purchase_date between p.start_date AND p.end_date) OR s.purchase_date IS NULL
GROUP BY
    p.product_id