# There are N houses with certain amount of money in each houses
# u r goal is to stolen money from these huses 
# condition is that you can't choose adjusent houses
# stoled the maximum amount from this houses


#-----------------------CODE---------------------

def max_stole(arr,i,n):
    if i>n-1:
        return 0
    else:
        return max(arr[i]+max_stole(arr,i+2,n),max_stole(arr,i+1,n))

print(max_stole([5,3,4,11,2],0,5))
print(max_stole([6,7,8,3,1],0,5))