function goPage(page) {
    if (!!content) {
        console.log('doing');
        content.src = page;
    }
}

goPage('/employee/list');