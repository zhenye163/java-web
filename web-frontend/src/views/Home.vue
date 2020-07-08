<template>
  <el-table style="width: 100%" :data="foods">
    <el-table-column prop="name" fixed="left" label="菜名" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="purchasePrice" label="采购价" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="salePrice" label="销售价" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="imageUrl" label="图片链接" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="createdTime" label="创建时间" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="createdBy" label="创建人" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="modifiedTime" label="更新时间" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column prop="modifiedBy" label="更新人" width="150" header-align="center" show-overflow-tooltip></el-table-column>
    <el-table-column fixed="right" label="操作" width="50" header-align="center">
      <template slot-scope="scope">
        <el-button @click="toOpenEditDialog(scope.$index, scheduledJobInfoList)" type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { getFoodList } from '@/api/food.js'
export default {
  data () {
    return {
      foods: []
    }
  },
  created () {
    this.getFoodListFromDB()
  },
  methods: {
    getFoodListFromDB () {
      let query = {
        pageNo: 1,
        pageSize: 10
      }
      getFoodList(query).then(res => {
        this.foods = res.data.content
      })
    }
  }
}
</script>

<style>

</style>
