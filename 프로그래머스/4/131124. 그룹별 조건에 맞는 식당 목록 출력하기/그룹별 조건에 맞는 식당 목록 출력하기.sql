--리뷰를 가장 많이 작성한 회원의 리뷰
--Oracle에서는 서브쿼리 안에서 ORDER BY를 사용할 때 ROWNUM과 함께 사용할 수 없으므로 서브쿼리를 래핑하여 처리
SELECT A.MEMBER_NAME, B.REVIEW_TEXT, TO_CHAR(B.REVIEW_DATE,'YYYY-MM-DD') AS REVIEW_DATE
FROM MEMBER_PROFILE A JOIN REST_REVIEW B
ON A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID IN (SELECT MEMBER_ID
                     FROM (SELECT MEMBER_ID, COUNT(MEMBER_ID) AS CNT
                            FROM REST_REVIEW
                            GROUP BY MEMBER_ID
                            ORDER BY CNT DESC)
                     WHERE ROWNUM = 1)
ORDER BY B.REVIEW_DATE, B.REVIEW_TEXT;