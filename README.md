# buplana

<!--- These are examples. See https://shields.io for others or to customize this set of shields. You might want to include dependencies, project status and licence info here --->
![GitHub repo size](https://img.shields.io/github/repo-size/mab9/buplana)
![GitHub contributors](https://img.shields.io/github/contributors/mab9/buplana)
![GitHub stars](https://img.shields.io/github/stars/mab9/buplana?style=social)
![GitHub forks](https://img.shields.io/github/forks/mab9/buplana?style=social)
<!--![Twitter Follow](https://img.shields.io/twitter/follow/mab9?style=social)-->

Buplana is a tool to create simple budgets to track expenses. To that it servers as a test project to try some architectural concepts and technologies.

<!-- ![pwa home view](pwa/src/assets/pwa.png "pwa home view") add image --> 

## Basics  development

Requirements:
- Java 21
- docker with compose
- Node for Angular 17

Start project - Linux and macOS:

todo finalize

```
0. git clone https://github.com/mab9/buplana.git
1. cd buplana
2. docker compose -f compose-local.yml up -d
3. cd spa && npm installs
3. cd spa && npm run start
4. cd backent && ../mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

### Frontend


### Some docker commands

build images

    cd backent
    docker build -t mabru/buplana-backent .
    cd spa
    docker build -t mabru/buplana-spa .


## Contributing to buplana
<!--- If your README is long or you have some specific process or steps you want contributors to follow, consider creating a separate CONTRIBUTING.md file--->
To contribute to buplana, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the original branch: `git push origin buplana/<location>`
5. Create the pull request.

Test your code well, changes to main branche are deployed instantly.

Alternatively see the GitHub documentation on [creating a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## My next ideas

- [ ] Add quarkus backend
- [ ] Replace java with Kotlin
- [ ] Provide kubernetes resources for k8s deployment

## Contributors

Thanks to the following people who have contributed to this project:

* [@mab9](https://github.com/mab9) 📖

<!-- You might want to consider using something like the [All Contributors](https://github.com/all-contributors/all-contributors) specification and its [emoji key](https://allcontributors.org/docs/en/emoji-key). -->

## Contact

If you want to contact me you can reach me at **marcantoine.bruelhart@gmail.com.**

## License
<!--- If you're not sure which open license to use see https://choosealicense.com/--->

This project uses the following license: [GNU GPLv3](https://choosealicense.com/licenses/gpl-3.0/).











