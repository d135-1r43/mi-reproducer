# mi-reproducer

This project is a simple reproduces of my kogito bug.

## Bug description

I'm using 'Multiple Instance's to process a list of Strings.  
The results should be saved in the list `greeting`.

As you can read in below `'greeting' changed value from: 'null', to: '[]'`, result is empty.

If you have any idea, pls contant me.

## Log

```
2023-09-08 10:46:10,013 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Workflow 'reproducer' (8363b75b-eb84-4d10-bd97-6130e09bae9a) completed
2023-09-08 10:46:22,967 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Starting workflow 'reproducer' (93f2f27e-b460-4f8f-9aab-6d8e7277947a)
2023-09-08 10:46:22,967 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'myname' value: 'Michael'
2023-09-08 10:46:22,968 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Start' for process 'reproducer' (93f2f27e-b460-4f8f-9aab-6d8e7277947a)
2023-09-08 10:46:22,968 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Build List' for process 'reproducer' (93f2f27e-b460-4f8f-9aab-6d8e7277947a)
2023-09-08 10:46:22,969 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'names' changed value from: 'null', to: '[Foo, Bar, Michael]'
2023-09-08 10:46:22,969 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Run subprocess' for process 'reproducer' (93f2f27e-b460-4f8f-9aab-6d8e7277947a)
2023-09-08 10:46:22,970 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable '3:2:localname' changed value from: 'null', to: 'Foo'
2023-09-08 10:46:22,970 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable '3:2:localname' changed value from: 'null', to: 'Bar'
2023-09-08 10:46:22,970 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable '3:2:localname' changed value from: 'null', to: 'Michael'
2023-09-08 10:46:22,972 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Starting workflow 'subprocess' (d51ce85e-07a1-44a4-9e68-b52853ffe8de)
2023-09-08 10:46:22,972 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'localname' value: 'Foo'
2023-09-08 10:46:22,972 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Start' for process 'subprocess' (d51ce85e-07a1-44a4-9e68-b52853ffe8de)
2023-09-08 10:46:22,973 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Just add a word' for process 'subprocess' (d51ce85e-07a1-44a4-9e68-b52853ffe8de)
2023-09-08 10:46:22,974 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'message' changed value from: 'null', to: 'Hello Foo'
2023-09-08 10:46:22,974 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'End' for process 'subprocess' (d51ce85e-07a1-44a4-9e68-b52853ffe8de)
2023-09-08 10:46:22,975 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Workflow 'subprocess' (d51ce85e-07a1-44a4-9e68-b52853ffe8de) completed
2023-09-08 10:46:22,976 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable '3:foreach_output' changed value from: 'null', to: '[]'
2023-09-08 10:46:22,977 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Starting workflow 'subprocess' (9355bafc-d091-44af-b849-3568c2bf110b)
2023-09-08 10:46:22,980 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'localname' value: 'Bar'
2023-09-08 10:46:22,981 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Start' for process 'subprocess' (9355bafc-d091-44af-b849-3568c2bf110b)
2023-09-08 10:46:22,981 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Just add a word' for process 'subprocess' (9355bafc-d091-44af-b849-3568c2bf110b)
2023-09-08 10:46:22,981 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'message' changed value from: 'null', to: 'Hello Bar'
2023-09-08 10:46:22,982 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'End' for process 'subprocess' (9355bafc-d091-44af-b849-3568c2bf110b)
2023-09-08 10:46:22,982 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Workflow 'subprocess' (9355bafc-d091-44af-b849-3568c2bf110b) completed
2023-09-08 10:46:22,983 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable '3:foreach_output' changed value from: '[]', to: '[]'
2023-09-08 10:46:22,983 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Starting workflow 'subprocess' (eb57e3ef-81c3-46e9-a953-b2bf0a4090e8)
2023-09-08 10:46:22,983 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'localname' value: 'Michael'
2023-09-08 10:46:22,983 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Start' for process 'subprocess' (eb57e3ef-81c3-46e9-a953-b2bf0a4090e8)
2023-09-08 10:46:22,984 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'Just add a word' for process 'subprocess' (eb57e3ef-81c3-46e9-a953-b2bf0a4090e8)
2023-09-08 10:46:22,984 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'message' changed value from: 'null', to: 'Hello Michael'
2023-09-08 10:46:22,984 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'End' for process 'subprocess' (eb57e3ef-81c3-46e9-a953-b2bf0a4090e8)
2023-09-08 10:46:22,984 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Workflow 'subprocess' (eb57e3ef-81c3-46e9-a953-b2bf0a4090e8) completed
2023-09-08 10:46:22,985 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable '3:foreach_output' changed value from: '[]', to: '[]'
2023-09-08 10:46:22,985 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Variable 'greeting' changed value from: 'null', to: '[]'
2023-09-08 10:46:22,985 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Triggered node 'End' for process 'reproducer' (93f2f27e-b460-4f8f-9aab-6d8e7277947a)
2023-09-08 10:46:22,985 INFO  [org.kie.kog.qua.pro.dev.DevModeWorkflowLogger] (executor-thread-0) Workflow 'reproducer' (93f2f27e-b460-4f8f-9aab-6d8e7277947a) completed
````

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.