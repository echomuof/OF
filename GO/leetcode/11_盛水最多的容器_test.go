/**
 *
 * @author: echomuof
 * @created: 2020/11/25
 */
package leetcode

func maxArea(height []int) int {
	l, r := 0, len(height)-1
	max := 0
	for l != r {
		minHeight := 0
		if height[l] < height[r] {
			minHeight = height[l]
			l++
		} else {
			minHeight = height[r]
			r--
		}
		curArea := minHeight * (r - l + 1)
		if curArea > max {
			max = curArea
		}
	}
	return max
}
