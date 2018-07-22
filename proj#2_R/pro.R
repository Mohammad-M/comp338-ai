library(C50)
library(ggplot2)
library(datasets)
Sys.setlocale("LC_ALL","Arabic")

dataset = iris[1:50 , 1:5]
View(dataset)
set.seed(17)
shu = dataset[order(runif(nrow(dataset))) , ] 


tdata = shu[1:floor(nrow(shu)*0.5), ]
tdata = shu[(floor(nrow(shu)*0.5)+1) : nrow(shu) , ]
View(tdata)

m = C5.0(tdata[ ,-5],tdata[ ,5]  )
summary(m)

plot(m , type = "s" , main = "Disition tree")

