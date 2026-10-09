# 安装与使用

使用 **Minecraft 1.21.1 / Fabric / Java 21**，不要混用 NeoForge 版本。依赖要求：

| 依赖 ID | 版本约束 |
| --- | --- |
| `fabricloader` | `>=0.16.10` |
| `fabric-api` | `*` |
| `minecraft` | `~1.21.1` |
| `java` | `>=21` |

按 [构建方法](BUILDING.md) 生成 Mod JAR，与 Fabric API 一起放入游戏实例的 `mods/`。单人装在客户端；多人需在客户端和 Fabric 服务器安装相同版本，因为方块注册和同步需要两端支持。

使用已有世界前先备份。仓库不含存档或运行配置，整理时也未验证游戏运行和多人兼容。
