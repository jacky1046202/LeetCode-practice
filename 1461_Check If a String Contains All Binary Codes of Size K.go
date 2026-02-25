func hasAllCodes(s string, k int) bool {
    values := make(map[string]bool)
    max := math.Pow(2, float64(k))
    inpA := strings.Split(s, "")

    for i := 0;  i <= len(s)-k; i++{
        values[strings.Join(inpA[i: i+k], "")] = true
    }

    return int(max) == len(values)
}
