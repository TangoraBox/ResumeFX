# ResumeFX (JavaFX Webview of jsonresume files)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Build Status](https://travis-ci.com/TangoraBox/ResumeFX.svg?branch=master)](https://travis-ci.com/TangoraBox/ResumeFX)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.tangorabox%3Aresume-fx&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.tangorabox%3Areactive-desk-fx)


ResumeFX renders a JavaFX view of .json file that follows [jsonresume.org](https://jsonresume.org) standard and has the
necessary configuration to be embedded in the web browser thanks to [JPro](https://www.jpro.one).

You can view a production example with my own resume here: https://cv.tangorabox.com

**The architecture style follows MVVM with minimal and very clean code thanks to the help of my 
[own JavaFX micro-framework library](https://github.com/TangoraBox/ReactiveDeskFX).**

JSON file loading and validation have been delegated to a 
[third-party library](https://github.com/eaxdev/Java-JsonResume-Validator) to speed up development.

For the graphic icons, I have used [FontAwesomeFX library](https://bitbucket.org/Jerady/fontawesomefx/src/master/).

In the test folder, I wrote some classes to prototype each component, and I have used
[CSSFX](https://github.com/McFoggy/cssfx) and my own [Component-Inspector](https://github.com/TangoraBox/ComponentInspector) 
to speed up CSS style prototyping.

---

## Features

- Run on desktop and web browser (`mvn jpro:run`)

- Responsive layout

- Mobile layout

- `Dockerfile`, `docker-compose-yml` and `.gitlab-ci.yml` CI/CD example files

- JSON file can be loaded externally to allow file edition without redeploy the project (see `docker-compose.yml`)

---

## Usage 

Java 11 or higher is required.

- To launch as desktop mode, simply run ResumeFXLauncher class. 
- To launch as web-browser mode, execute `mvn jpro:run`

### JSON file Limitations

- Some fields (ex: skill level) must be numeric and date fields must in YYYY-MM-DD pattern
- picture field must be a valid and accessible url

---

## Contributing

> If you want to contribute to upgrade this project with new features or fixing bugs, you're welcome, please make a pull request.

---

## Team


| <a href="https://github.com/garzy" target="_blank">**GaRzY**</a> | 
| :---: 
| [![GaRzY](https://avatars0.githubusercontent.com/u/10849239?s=200)](https://github.com/garzy)
| <a href="https://github.com/garzy" target="_blank">`github.com/garzy`</a> | 


---

## Support

Reach out to me at one of the following places!

- Mail to [info@tangorabox.com](mailto:info@tangorabox.com)
- Twitter at <a href="http://twitter.com/garzydj" target="_blank">`@garzydj`</a>

---


## License

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

- **[GPL v3](https://opensource.org/licenses/gpl-3.0.html)**
