data<-read.table('urandom.out',col.names=c('values'))
summary(data)

subset<-head(data$values,1000)
summary(subset)

png("urandomRandom.png", width=600, height=600)
plot(subset)
dev.off()

png("urandomSorted.png", width=600, height=600)
plot(sort(subset))
dev.off()
