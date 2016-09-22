data<-read.table('random.out',col.names=c('values'))
summary(data)

subset<-head(data$values,1000)
summary(subset)

png("randomRandom.png", width=600, height=600)
plot(subset)
dev.off()

png("randomSorted.png", width=600, height=600)
plot(sort(subset))
dev.off()
