MACHINE WD_M2 INCLUDES WD_M1
CONSTANTS y
PROPERTIES
  y:NATURAL &
  10*y > 1
VARIABLES w
INVARIANT w:NAT
INITIALISATION w:=0
OPERATIONS inc = BEGIN w:=w+1 END
END