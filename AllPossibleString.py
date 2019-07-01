# from itertools import permutations
# a,b =list(map(int,input().strip().split()))
# list_of_a =str(a)
# empty_list=[]
# permu = permutations(list_of_a)
# permu=[int("".join(x)) for x in permu]
# permu.sort()
# for item in permu:
#     if item>b:
#         result = b
#         break
#     else:
#         result =-1
# print(result)

#--------------------------------------------------
from itertools import permutations
a,b = input().strip().split()
final_nums = [int("".join(term)) for term in permutations(a)]
final_nums.sort()
for term in final_nums:
    if term > int(b):
        print(term)
        break
else:
    print(-1)