data Tipo1 = Uno | Dos 

a:: Int
a=10

(<+>) :: Int -> Int -> Int
a <+> b = (+) a b

valorDoble :: Integer -> Integer
valorDoble = (*2)

valorDoble' :: Integer -> Integer
valorDoble' x = x+x


operacion :: Int -> Int -> Int
operacion 0 y = y
operacion x y = x* y

abs' x
   | x >= 0 = x
   | otherwise = (-x)

mal x
   | x == 0 = 1
   | x > 0 =  x +1
   | otherwise = x -1

fac :: Integer -> Integer
fac 0 = 1
fac 1 = 1
fac n
    | n > 1 =  n * fac ( n - 1)
    | otherwise = error "Usted ha invocado factorial con un valor negativo esto no converge" 

raices :: Float -> Float -> Float -> (Float, Float)
raices a b c = ((( (-1)* b  + f ) / g , ((-1)*b - f) / g)
       where  f = sqrt( ( b * b ) - (4 * a * c))
              g = 2*a
