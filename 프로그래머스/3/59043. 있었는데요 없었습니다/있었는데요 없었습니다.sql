select ai.ANIMAL_ID, ai.NAME
from animal_ins ai
join animal_outs ao on ai.animal_id = ao.animal_id
where ao.datetime < ai.datetime
order by ai.datetime asc;