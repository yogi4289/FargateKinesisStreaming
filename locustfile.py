from locust import HttpUser, TaskSet, task

def index(l):
    l.client.get("/")

class UserBehavior(TaskSet):
    tasks = {index:1}

    def on_start(self):
        index(self)

class WebsiteUser(HttpUser):
    task_set = UserBehavior
    min_wait = 1000
    max_wait = 2000

    @task(2)
    def index(self):
        self.client.get("/")

    @task(3)
    def index(self):
        self.client.post("/", json={"data":"AWS Community Day INDIA- This is our load testing record"})
