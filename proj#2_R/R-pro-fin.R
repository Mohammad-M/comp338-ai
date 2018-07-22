library(C50);
Sys.setlocale("LC_ALL","Arabic")
dataset = read.table(file ="C:/Data/dataset-all.csv",header = T,sep = ",",encoding = "UTF-8")
shuDataset = dataset[order(runif(nrow(dataset))),]
trainD=shuDataset[1:(floor(nrow(shuDataset)*0.7)),]
testD=shuDataset[(floor(nrow(shuDataset)*0.7)+1):nrow(shuDataset),]
dataModel=C5.0(trainD[,c(-1,-2,-3,-6,-9,-10,-11,-12,-17)],trainD[,17])
summary(dataModel)
plot(dataModel,type="s",main="Decision Tree")

result=predict(dataModel,testD)
View(cbind(testD,result))
tmp = result == testD[,17]
length(which(tmp))
length(tmp)

accuracy = length(which(tmp)) / length(tmp) * 100.0
sprintf("The accuracy = %.2f", accuracy)

