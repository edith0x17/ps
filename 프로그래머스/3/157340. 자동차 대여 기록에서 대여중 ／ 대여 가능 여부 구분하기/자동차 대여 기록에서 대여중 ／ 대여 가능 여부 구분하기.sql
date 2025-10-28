SELECT DISTINCT CAR_ID, 
    IF(
        CAR_ID IN (
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            # 시작 <= '2022-10-16' <= 끝
            WHERE START_DATE <= '2022-10-16' AND '2022-10-16' <= END_DATE
            ),
        '대여중',
        '대여 가능'
    ) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY CAR_ID DESC;
