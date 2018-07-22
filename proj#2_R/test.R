library(C50);
Sys.setlocale("LC_ALL","Arabic")
dataset = read.table(file ="C:/Data/Idone.txt",sep = ",",encoding = "UTF8")
#dataset = read.table(file.choose(),sep = ",",encoding = "UTF8")
View(dataset)

words = strsplit(dataset.line, " ")
View(words)
