-- 주문량을 더한 테이블 만들기
SELECT FLAVOR
FROM (SELECT FLAVOR
     FROM (SELECT *
          FROM JULY
          UNION ALL
          SELECT *
          FROM FIRST_HALF)
          GROUP BY FLAVOR
          ORDER BY SUM(TOTAL_ORDER) DESC
     )
WHERE ROWNUM <= 3;