<template>
    <!--调用该组件时填入的字符串 将被置入slot中-->
    <div class="container content-field">
        <div class="card">
            <div class="card-body">
                <slot></slot>
            </div>
        </div>
    </div>
</template>

<script>
</script>

<style>
div.content-field {
    margin-top: 20px;
}
</style>