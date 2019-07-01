# 31   0,0,2,2,3,5,9,9,9,9
def no_of_day(day,l):
    no1= -1
    maxi_mum_day=day
    while day>0:
        rem = day%10
        if rem not in l:
            day=maxi_mum_day-1
            maxi_mum_day=day
            if no1 !=-1:
                l.append(no1)
        else:
            no1=rem
            l.remove(no1)
            day//=10
    if maxi_mum_day<10:
        maxi_mum_day=str(0)+str(maxi_mum_day)
    maxi_mum_day=str(maxi_mum_day)
    return maxi_mum_day
    

nos=list(map(int,input().split(',')))
nos=[no for no in sorted(nos)]
monthes={1:31,2:29,3:31,4:30,5:31,6:30,7:31,8:31,9:30,10:31,11:30,12:31}

max_dd=-1
max_mm=12
max_hh=24
max_min=60
count = 0
no1,no2 = 0,0

for no in nos:
    if no>=2:
        count+=1
    else:
        break
if count == len(nos):
    print(0)
else:
    
    max_mm= int(no_of_day(max_mm,nos))
    max_dd= int(no_of_day(monthes[max_mm],nos))
    max_min=int(no_of_day(max_min,nos))
    max_hh= int(no_of_day(max_hh,nos))

    if max_min>=60:
        max_min=max_min%60
        max_hh+=max_min//60
    if max_hh>=24:
        max_hh=max_hh%24
        if max_hh<10:
            max_hh=str(0)+str(max_hh)
    # MM/DD HH:MM
    print(f"{max_mm}/{max_dd} {max_hh}:{max_min}")

    
