# FargateKinesisStreaming
A Real Time Data Streaming solution having Producer and Consumer tasks running in serverless fashiopn as Fargate Containers.

### Auto Scaling Support 
Auto Scaling Support using ECS Service Auto scaling policy

### Kinesis Producer
Written in Java using Kinesis Producer Library

### Kinesis Consumer
Written in Java using Kinesis Consumer Library as enahanced fan out fashion

### How to run
Execute cloudformation/awscug-kinesis-ecr-images.yml to create ECR registery for both Producer and Consumer, kinesis data stream, kinesis firehose, S3 bucket, Code Build Project.

Execute cloudformation/awscug-kinesis-fargate-pipeline.yml to create ECS Fargate Tasks for Producer and Consumer, ALB, associated roles, cloudwatch Dashboard to monitor metrics
