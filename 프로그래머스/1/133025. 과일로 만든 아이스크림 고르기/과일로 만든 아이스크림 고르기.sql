select a.FLAVOR from FIRST_HALF a inner join ICECREAM_INFO b on a.FLAVOR = b.FLAVOR 
where TOTAL_ORDER >= 3000 and INGREDIENT_TYPE = 'fruit_based'
order by TOTAL_ORDER desc;




# FIRST_HALF
# ICECREAM_INFO