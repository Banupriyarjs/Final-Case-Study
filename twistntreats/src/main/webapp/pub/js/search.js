const search = document.querySelector('.inputgroup input'),
    table_rows = document.querySelectorAll('tbody tr'),
    table_headings = document.querySelectorAll('thead th');

// 1. Searching for specific data of HTML table
search.addEventListener('input', searchTable);
function searchTable() {

    table_rows.forEach((row, i) => {
          // Get the third cell (td) in the row (index 2)
          let thirdCell = row.querySelectorAll('td')[2];


          if (!thirdCell) {
              // If there is no third cell, skip the row
              return;
          }

          let cell_data = thirdCell.textContent.toLowerCase(),
              search_data = search.value.toLowerCase();

          // Toggle 'hide' class based on whether the search_data is found in cell_data
          row.classList.toggle('hide', cell_data.indexOf(search_data) < 0);
          row.style.setProperty('--delay', i / 25 + 's');
      })

      document.querySelectorAll('tbody tr:not(.hide)').forEach((visible_row, i) => {
          visible_row.style.backgroundColor = (i % 2 == 0) ? 'transparent' : '#0000000b';

    });
   }
/*
function searchTable() {
alert("hi");
alert(search);
    table_rows.forEach((row, i) => {
        let table_data = row.textContent.toLowerCase(),
            search_data = search.value.toLowerCase();

        row.classList.toggle('hide', table_data.indexOf(search_data) < 0);
        row.style.setProperty('--delay', i / 25 + 's');
    })

    document.querySelectorAll('tbody tr:not(.hide)').forEach((visible_row, i) => {
        visible_row.style.backgroundColor = (i % 2 == 0) ? 'transparent' : '#0000000b';
    });
}*/