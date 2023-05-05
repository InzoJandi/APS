#TOTAL_ORDER기준 내림차순, 같다면 출하번호로 오름차순
SELECT flavor from FIRST_HALF
order by TOTAL_ORDER desc, SHIPMENT_ID