# 构建

安装 **JDK 21 和 Gradle 8.12**。工程使用 Fabric Loom 1.9 系列，不附 JDK、Gradle 缓存或 Wrapper 二进制。依赖从 Fabric Maven、Maven Central 和 Gradle Plugin Portal 获取，首次构建需要网络。

在仓库根目录运行：

```powershell
gradle --version
gradle clean build --console=plain
```

产物位于 `build/libs/`。安装普通重映射 JAR，`-sources.jar` 和开发 JAR 不放入游戏。构建只生成 Mod 产物；仓库不含本机修复依赖、测试世界或历史验证入口，也不会自动安装游戏。

代码和旧资源的 AFL-3.0 许可保持不变，构建或再分发时请保留 [来源与许可说明](THIRD_PARTY_NOTICES.md)。
