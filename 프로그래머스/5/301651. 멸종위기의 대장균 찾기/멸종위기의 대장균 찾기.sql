#46
WITH RECURSIVE gens AS (
  -- 1) Anchor member (시작 부분, 최초 실행)
  -- 🔹 1세대: 부모가 없는 개체 (최초 개체)
  SELECT id, 1 AS gen
  FROM ecoli_data
  WHERE parent_id IS NULL

  UNION ALL

  -- 2) Recursive member (자기 자신을 참조해서 반복 실행)
  -- 🔸 재귀적으로 자식 찾기: 자식은 부모보다 세대가 +1
  SELECT e.id, g.gen + 1
  FROM ecoli_data e
  INNER JOIN gens g ON e.parent_id = g.id
), 
children AS (
  SELECT a.id AS parent, b.id AS child
  FROM ecoli_data a
  LEFT JOIN ecoli_data b ON a.id = b.parent_id
)
SELECT COUNT(*) as count, g.gen as generation
FROM gens g
LEFT JOIN children c ON g.id = c.parent
WHERE c.child IS NULL
GROUP BY g.gen;