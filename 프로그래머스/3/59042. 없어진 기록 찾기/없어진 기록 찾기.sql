select ao.animal_id, ao.name
from animal_outs ao
left outer join animal_ins ai on ao.animal_id = ai.animal_id
where ai.animal_id is null
order by ao.animal_id asc;