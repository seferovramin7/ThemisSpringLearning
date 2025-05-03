# Deploying to Digital Ocean with GitHub Actions

This guide explains how to deploy this Spring Boot application to Digital Ocean using GitHub Actions.

## Prerequisites

1. **GitHub Account**
   - Your code must be hosted on GitHub
   - Repository must have the branch specified in your workflow file (main or master)

2. **Docker Hub Account**
   - For storing container images

3. **Digital Ocean Account**
   - You need an account with access to App Platform

## Setup Steps

### 1. Set up GitHub Secrets

Add the following secrets to your GitHub repository:

- `DOCKERHUB_USERNAME`: Your Docker Hub username
- `DOCKERHUB_TOKEN`: A Docker Hub access token (create in Docker Hub account settings)
- `DIGITALOCEAN_ACCESS_TOKEN`: Your Digital Ocean API token (generate in API section of Digital Ocean dashboard)
- `DIGITALOCEAN_APP_ID`: The ID of your Digital Ocean App (available after app creation)

### 2. Create Digital Ocean App

1. Log into Digital Ocean
2. Go to App Platform
3. Click "Create App"
4. Choose "GitHub" as the source
5. Select your repository
6. Configure according to `.do/app.yaml` settings
7. Complete the setup wizard
8. Note the App ID from the URL (apps/[APP_ID]) and add it as a GitHub secret

### 3. Update Repository Settings

1. Make sure the GitHub Actions workflow is in the `.github/workflows` directory
2. Update the App Spec file (`.do/app.yaml`) with your GitHub repository details
3. Push the changes to your repository

### 4. Trigger the Workflow

The workflow will automatically run when you push to the main branch, or you can manually trigger it from the "Actions" tab in GitHub.

## Troubleshooting

- Check GitHub Actions logs for detailed error information
- Ensure all secrets are correctly set
- Verify your Dockerfile builds successfully locally

## Application URLs

After successful deployment, your application will be available at the URL displayed in the Digital Ocean App Platform dashboard.

Health check endpoint: `/actuator/health` 