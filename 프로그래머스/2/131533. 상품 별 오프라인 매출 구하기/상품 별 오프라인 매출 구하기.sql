# 상품코드 별 매출액(판매가 * 판매량) 합계
# 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬
select p.PRODUCT_CODE, sum(o.SALES_AMOUNT * p.PRICE) as SALES
from OFFLINE_SALE o
join PRODUCT p on o.PRODUCT_ID = p.PRODUCT_ID
group by p.PRODUCT_CODE
order by SALES desc, p.PRODUCT_CODE asc;