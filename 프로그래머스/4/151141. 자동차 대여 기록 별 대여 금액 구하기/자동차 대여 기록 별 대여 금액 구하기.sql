--종류는 트럭, 대여기록 별(7,30,90) 대여 금액
SELECT B.HISTORY_ID,
CASE
    WHEN(B.END_DATE-B.START_DATE+1 >= 90)
        THEN A.DAILY_FEE*(B.END_DATE-B.START_DATE+1)*(1-(SELECT DISCOUNT_RATE * 0.01
                                                      FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                      WHERE DURATION_TYPE = '90일 이상' AND CAR_TYPE = '트럭'))
    WHEN(B.END_DATE-B.START_DATE+1 >= 30)
        THEN A.DAILY_FEE*(B.END_DATE-B.START_DATE+1)*(1-(SELECT DISCOUNT_RATE * 0.01
                                                      FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                      WHERE DURATION_TYPE = '30일 이상' AND CAR_TYPE = '트럭'))
                                                      
    WHEN(B.END_DATE-B.START_DATE+1 >= 7)
        THEN A.DAILY_FEE*(B.END_DATE-B.START_DATE+1)*(1-(SELECT DISCOUNT_RATE * 0.01
                                                      FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                      WHERE DURATION_TYPE = '7일 이상' AND CAR_TYPE = '트럭'))
                                                      
     ELSE A.DAILY_FEE*(B.END_DATE-B.START_DATE+1)
END AS FEE
FROM CAR_RENTAL_COMPANY_CAR A
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
ON A.CAR_ID = B.CAR_ID
WHERE A.CAR_TYPE = '트럭'
ORDER BY FEE DESC, B.HISTORY_ID DESC;                    