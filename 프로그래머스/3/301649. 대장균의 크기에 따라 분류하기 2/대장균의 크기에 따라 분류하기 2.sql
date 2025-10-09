WITH ranked AS (
    SELECT
        ID,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS bucket
    FROM ECOLI_DATA
)
SELECT
    ID,
    CASE bucket
        WHEN 1 THEN 'CRITICAL'
        WHEN 2 THEN 'HIGH'
        WHEN 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM ranked
ORDER BY ID;