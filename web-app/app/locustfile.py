from locust import HttpUser, task, between

class CryptoWebUser(HttpUser):
    wait_time = between(1, 5)

    @task
    def view_homepage(self):
        self.client.get("/")

    @task
    def view_cryptohome(self):
        self.client.get("/cryptohome")

    @task
    def view_cryptovision(self):
        self.client.get("/cryptovision/Bitcoin")

    @task
    def api_cryptohome(self):
        self.client.get("/api/cryptohome")

    @task
    def api_cryptovision(self):
        self.client.get("/api/cryptovision/Bitcoin")

    @task
    def authenticated_account_view(self):
        with self.client.post("/login", data={"email": "test@example.com", "password": "password"}, catch_response=True) as response:
            if response.status_code == 200:
                self.client.get("/account")