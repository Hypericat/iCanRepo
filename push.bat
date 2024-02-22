Setlocal EnableDelayedExpansion
for %%a in (%*) do set commit=!commit! %%a
git add .
git commit -m "%commit%"
git remote add origin https://github.com/Hypericat/iCanRepo.git
git branch -M main
git push -u origin main
set /p DUMMY=Hit ENTER to continue...