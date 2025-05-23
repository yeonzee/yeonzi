SELECT A.ID, IFNULL(B.CNT,0) AS CHILD_COUNT
FROM ECOLI_DATA A
LEFT JOIN (SELECT PARENT_ID, COUNT(PARENT_ID) AS CNT
     FROM ECOLI_DATA
     GROUP BY PARENT_ID) B
ON A.ID = B.PARENT_ID
ORDER BY ID;