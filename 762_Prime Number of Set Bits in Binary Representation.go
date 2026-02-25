func countPrimeSetBits(left int, right int) int {
    ans := 0

    for i := left; i <= right; i++{
        if checkPrim(toBinary(i)){
            ans++
        }
    }

    return ans
}

func toBinary(orig int) int{
    var bi []int

    for orig >= 2{
        if orig % 2 != 0{
            bi = append(bi, 1)        
        }else{
            bi = append(bi, 0)        
        }

        orig /= 2        
    }

    bi = append(bi, 1) 

    count := 0
    for _, val := range bi{
        if val == 1{
            count++
        } 
    }
    // fmt.Println((bi))

    return count
}

func checkPrim(inp int) bool{
    ans := true
    // sqrt := math.Sqrt(float64(inp))
    if inp == 1{
        return false
    } 
    if inp == 2 || inp == 3 {
        return ans
    }

    for i := 2; i*i <= inp; i++ {
        // fmt.Print(i)
        
        if inp % i == 0 {
            ans = false
            break 
        }
    }

    return ans
}