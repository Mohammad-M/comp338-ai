library(C50);
Sys.setlocale("LC_ALL","Arabic")

dataset = read.table(file ="C:/Data/dataset-all.csv",header = T,sep = ",",encoding = "UTF-8")
View(dataset)
str(dataset)
summary(dataset)
