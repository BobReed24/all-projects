def sorted_arrays_intersection(arr1, arr2, arr3)
  result = []

  p1 = p2 = p3 = 0

  while (p1 < arr1.count) && (p2 < arr2.count) && (p3 < arr3.count)
    if arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]
      result.push(arr1[p1])

      p1 += 1
      p2 += 1
      p3 += 1
    elsif arr1[p1] < arr2[p2]
      p1 += 1
    elsif arr2[p2] < arr3[p3]
      p2 += 1
    else
      p3 += 1
    end
  end

  result
end

arr1 = [1, 2, 3, 4, 5]
arr2 = [1, 2, 5, 7, 9]
arr3 = [1, 3, 4, 5, 8]
print(sorted_arrays_intersection(arr1, arr2, arr3))

arr1 = [197, 418, 523, 876, 1356]
arr2 = [501, 880, 1593, 1710, 1870]
arr3 = [521, 682, 1337, 1395, 1764]
print(sorted_arrays_intersection(arr1, arr2, arr3))

