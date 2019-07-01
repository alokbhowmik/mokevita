# One boy start climbing from 0 stress and he want to raching to the nth stress he can jump 1 or 2 stress at a time 
# and you have to find how many possible way of reaching to the nth stress
def total_ways(i,n):
    if i>n:
        return 0
    elif i==n:
        return 1
    else:
        return total_ways(i+1,n)+total_ways(i+2,n)

print(total_ways(0,10)) 
print(total_ways(0,4)) 
