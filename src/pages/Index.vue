<template>
  <div>
    <el-menu class="app-menu">
      <el-menu-item index="1" class="app-menu-item">redis-info Redis调度平台</el-menu-item>
    </el-menu>

    <el-badge is-dot class="item">Redis 实例信息</el-badge>
    <el-table :data="tableData" border style="width: 100%" size="small">
      <el-table-column type="index" width="50"/>
      <el-table-column prop="ip" label="IP"/>
      <el-table-column prop="port" label="port"/>
      <el-table-column prop="version" label="version"/>
      <el-table-column prop="processId" label="process_id"/>
      <el-table-column prop="role" label="role"/>
      <el-table-column prop="connectedSlaves" label="connected_slaves"/>
      <el-table-column prop="aofEnabled" label="aof_enabled"/>
    </el-table>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        tableData: [{
          ip: '127.0.0.1',
          port: '6379',
          version: '3.2.1',
          processId: '1111',
          role: 'master',
          connectedSlaves: '0',
          aofEnabled: 'false',
        }]
      }
    }
  }
</script>

<style>
  .app-menu {
    margin-top: 5px;
    margin-bottom: 5px;
    background-color: #409EFF;
  }
  .app-menu-item {
    text-align: center;
    font-size: large;
  }
  .item {
    margin-top: 10px;
    margin-bottom: 10px;
  }
</style>
