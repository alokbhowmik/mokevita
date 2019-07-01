#one robort wants to move through a mXn gird 
#1>it start from (0,0) to (m-1,n-1)
#It can go down or right of the curve 
#Now you have to find that how many possible way of reaching (m-1,n-1)


#-----------------------------------CODE--------------------------
def possible_ways(i,j,m,n):
    if i>m-1 or j>n-1:
        return 0
    elif i==m-1 and j==n-1:
        return 1
    else:
        return possible_ways(i,j+1,m,n) + possible_ways(i+1,j,m,n)

print(possible_ways(0,0,3,3))