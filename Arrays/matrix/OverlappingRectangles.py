t=int(input())
while(t>0):
    l1,r1,l2,r2=1,1,1,1
    l3,r3,l4,r4=2,2,2,2
    area1 = abs(l1-l2)*abs(r1-r2)
    area2 = abs(l3-l4)*abs(r3-r4)
    x_dist = (min(l2,l4) -
              max(l1,l3))
    y_dist = (min(r2,r4) -
              max(r1,r3))
    areaI = 0
    if x_dist > 0 and y_dist > 0:
        areaI = x_dist * y_dist
    print(area1+area2-areaI)
    
    t=t-1