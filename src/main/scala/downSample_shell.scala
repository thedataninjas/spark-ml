//imports

// set arguments
val data = args(0) // data in libSVM format
val percent = args(1) // the percentage of 1's to 0's

// create subset of only zeros
val zeros = data.filter(_.label==0)
// create subset of only ones
val ones = data.filter(_.label==1)

// get count of 0's
val zCount = zeros.count.toDouble
// get count of 1's
val zCount = ones.count.toDouble

// calculate the number of zeros that is needed to reach the desired percentage
val targetZeros = percent * ones
// calculate the percent of zeros needed to split zeros into
val zeroPercent = targetZeros / zeros

// split the 0's using zeroPercent to determine the amount
val downSampZeros = zeros.randomSplit(Array(zeroPercent, (1 - zeroPercent)))(0)

// join downsampled 0's with original 1's to make downsample data set
val downSampledData = ones.union(downSampZeros)

return downSampledData

