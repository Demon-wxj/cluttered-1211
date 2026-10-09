# Cluttered 2.1.0 本地移植来源

记录日期：2026-10-04。本工程是为用户本机制作的非官方 Minecraft 1.21.1 Fabric 移植，原 Mod、模型、纹理、音频和名称的作者权益仍归原作者及各素材权利人。本地兼容修改不表示获得原作者背书。

## 行为与素材基准

- 用户提供的原始文件：`LOCAL_WORKSPACE`。
- 原文件 SHA-256：`452842ccd91866fb6b8051239673c9907d7c38a576c0506d0018e75b0ed5d888`。
- 原文件 Mod ID：`luphieclutteredmod`；版本：`2.1.0`；入口包：`net.mcreator.clutteredmod`。本次保留原 ID，使用该版本的可观察行为与资源作为基准。
- [官方 2.1.0 Fabric 发行页面](https://modrinth.com/mod/cluttered/version/NOU4xHGw)标明适用于 Minecraft 1.20.1，说明由 unilock 完成 Fabric 移植。原作者在原文件元数据中记为 `blake, MCreator`；当前官方项目作者账号为 beelake。
- 找到并只读保存的源代码 fork：[unilock/Cluttered-1.19.2-MCreator-Fabric](https://github.com/unilock/Cluttered-1.19.2-MCreator-Fabric)，分支 `master`，提交 `71635fa6fda6e2d30acb75fbeb8e183bf0e6e058`。[gradle.properties](https://github.com/unilock/Cluttered-1.19.2-MCreator-Fabric/blob/71635fa6fda6e2d30acb75fbeb8e183bf0e6e058/gradle.properties)实际声明 Minecraft 1.20.1、Mod 2.1.0、Yarn 1.20.1+build.10、Fabric Loader 0.14.22、Fabric API 0.88.1+1.20.1；仓库名中的 1.19.2 不能代表该提交的构建目标。
- 为与用户提供的确切二进制一致，本次将原 jar 从 intermediary 映射转换到 Mojang 名称并使用 CFR 反编译，作为移植源代码起点，再与上述 1.20.1 源码 fork 核对。原始和转换文件保存在 `research/`。本次没有采用 Cluttered 3.x 的代码或资源来替换 2.x。

## 许可记录

原 jar 和上述 2.1.0 源码 fork 的 [fabric.mod.json](https://github.com/unilock/Cluttered-1.19.2-MCreator-Fabric/blob/71635fa6fda6e2d30acb75fbeb8e183bf0e6e058/src/main/resources/fabric.mod.json)均声明 `Academic Free License v3.0`。读取的源码提交没有独立 `LICENSE` 文件；原元数据中 `beelakes/Cluttered-1.19.2-MCreator-Fabric` 的链接已经失效，因此本说明另记实际仍可访问的 unilock fork。

本工程的 `LICENSE` 是根据原 2.x 元数据声明补附的 AFL-3.0 标准全文。文本来自 [SPDX 官方 license-list-data](https://raw.githubusercontent.com/spdx/license-list-data/main/text/AFL-3.0.txt)，可与 [Open Source Initiative 的 AFL-3.0 页面](https://opensource.org/license/AFL-3.0)核对。补附标准全文不表示原 fork 本来包含该文件，也不解决作者各历史版本声明的差异。

[当前官方项目页面](https://modrinth.com/mod/cluttered)声明 GPL-3.0-or-later，并明确 3.0 已重写代码、改变 Mod ID、重制模型，升级会影响旧储物方块内的物品。这是关于当前项目与新 3.x 的证据；本次没有把其 GPL 全文冒认为旧 2.1.0 fork 中存在的许可。本地移植保留原作者信息和 2.x 的 AFL 元数据，历史许可差异在此记录，公开再分发前应由权利人澄清具体适用条款。

## Minecraft 与 Fabric 迁移依据

- [Minecraft 24w18a 官方更新说明](https://www.minecraft.net/en-us/article/minecraft-snapshot-24w18a)：绘画变体改为数据驱动；路径为 `data/<namespace>/painting_variant/<id>.json`，`width` 和 `height` 以方块为单位，`asset_id` 指定绘画图集纹理。
- [Minecraft 1.21 正式版官方更新说明](https://feedback.minecraft.net/hc/en-us/articles/27547857163917-Minecraft-Java-Edition-1-21-Tricky-Trials)：正式版保留绘画、附魔和唱片的数据驱动迁移。
- [Minecraft Wild Update 官方更新说明](https://www.minecraft.net/en-us/article/the-wild-update-out-today-java)：生存模式可摆放的绘画由 `painting_variant/placeable` 标签控制。
- [Fabric 1.21 与 1.21.1 官方迁移说明](https://fabricmc.net/2024/05/31/121.html)：资源标识构造改为静态方法，数据包多个路径改为单数名，注册应在 ModInitializer 阶段完成。

本次将原 20 个绘画 ID 转为动态变体 JSON，保留纹理，尺寸由旧像素宽高除以 16 转为方块宽高，合并到 `minecraft:painting_variant/placeable`，不覆盖原版标签成员。
