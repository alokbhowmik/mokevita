n= int(input())
total_amt =int(input())
a_100=int(input())
a_200=int(input())
a_500=int(input())
a_1000=int(input())
balance =total_amt
c=0
while total_amt!=0:
    div = total_amt//100
    if div<=100 and c<=n:
        c+=min(div,total_amt%100)
        total_amt-=100*min(div,total_amt%100)
    div = total_amt//200
    if div<=100 and c<=n:
        c+=min(div,total_amt%200)
        total_amt-=100*min(div,total_amt%200)
    div = total_amt//500
    if div<=100 and c<=n:
        c+=min(div,total_amt%500)
        total_amt-=100*min(div,total_amt%500)
    div = total_amt//100
    if div<=1000 and c<=n:
        c+=min(div,total_amt%1000)
        total_amt-=100*min(div,total_amt%1000)
    else:
        c=0
        total_amt = balance



