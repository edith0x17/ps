SELECT 
    p.PRODUCT_ID,
    p.PRODUCT_NAME,
    SUM(o.AMOUNT * p.PRICE) AS TOTAL_SALES
FROM FOOD_ORDER o
JOIN FOOD_PRODUCT p ON o.PRODUCT_ID = p.PRODUCT_ID
WHERE o.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY p.PRODUCT_ID, p.PRODUCT_NAME, p.PRICE
ORDER BY TOTAL_SALES DESC, p.PRODUCT_ID ASC;
